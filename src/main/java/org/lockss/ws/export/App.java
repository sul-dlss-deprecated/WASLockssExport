package org.lockss.ws.export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
	public static final String applicationName = "LockssExportClient";

	private static final String EXPORT_SERVICE_PATH = "/ws/ExportService?wsdl";
	private static final int EXIT_CODE_SUCCESS = 0;
	private static final int EXIT_CODE_FAIL = -1;

	private static Options options;
	private static CommandLine cmdLine;
	
	private static String auIdsFileList;
	private static String outputDirectory;
	private static String userName;
	private static String password;
	private static String maxFileSize;
	private static String fileType;
	private static String compress;
	private static String auId;

	private static String lockssUri;

	public static void main(String[] args){
		parseCommandLineOptions(args);
		ExportServiceParams exportParam = parseExportParams();
		String[] auIdsList = null;
		if(auIdsFileList != null && auIdsFileList.length()>0){
			try {
				auIdsList = getAuIdsListFromFile();
			} catch (IOException e) {
				System.out.println("There is a problem reading from :"+auIdsFileList);
				e.printStackTrace();
				System.exit(EXIT_CODE_FAIL);
			}
		} else if(auId != null && auId.length() > 0){
			auIdsList = new String[]{auId};
		} else{
			System.out.println("AU id or AU id file list is missing.");
			System.exit(EXIT_CODE_FAIL);
		}

		ExportService port = null;
		try {
			port = defineWSLocator();
		} catch (ServiceException e) {
			System.out.println("Probleming in accessing WS");
			e.printStackTrace();
			System.exit(EXIT_CODE_FAIL);
		}
		for(int i = 0; i < auIdsList.length ; i++){
			System.out.println("Starting download "+auIdsList[i]);
			exportParam.setAuid(auIdsList[i]);
			exportParam.setFilePrefix(getFilePrefixFromAUId(auIdsList[i]));

			ExportServiceWsResult result = null;
			try {
				result = port.createExportFiles(exportParam);
			} catch (RemoteException e) {
				System.out.println("Problem in accessing the createExportfiles");
				e.printStackTrace();
			}
			try {
				writeFiles(result);
			} catch (FileNotFoundException e) {
				System.out.println("Problem in writting the files");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Problem in writting the files");
				e.printStackTrace();
			}		
			System.out.println("Download completed successfully for "+auIdsList[i]);
		}
	}

	private static String getFilePrefixFromAUId(String auId) {
		String defaultPrefix = "lockss_export";
		if(auId == null || auId.length() == 0){
			return defaultPrefix;
		}
		
		String[] fields = auId.split("\\|");
		if(fields.length >= 4){
			return fields[3];
		}
		return defaultPrefix;
	}

	private static ExportService defineWSLocator() throws ServiceException {
		ExportServiceImplServiceLocator locator = new ExportServiceImplServiceLocator();
		locator.setExportServiceImplPortEndpointAddress(lockssUri+EXPORT_SERVICE_PATH);
		ExportService port = locator.getExportServiceImplPort();
		org.lockss.ws.export.ExportServiceImplServiceSoapBindingStub prov = (org.lockss.ws.export.ExportServiceImplServiceSoapBindingStub)port;
	
		prov.setUsername(userName);
		prov.setPassword(password);
		return port;
	}

	private static String[] getAuIdsListFromFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(auIdsFileList));
		ArrayList<String> auIdArraList = new ArrayList<String>();
		while(reader.ready()){
			auIdArraList.add(reader.readLine());
		}
		reader.close();
		String[] auIds = new String[auIdArraList.size()];
		return auIdArraList.toArray(auIds);
	}

	private static void writeFiles(ExportServiceWsResult result)
			throws FileNotFoundException, IOException {
		if(result == null || result.getDataHandlerWrappers() == null){
			System.out.println(result);
			System.out.println("WS result is null");
			return;
		}
		for (int i = 0; i < result.getDataHandlerWrappers().length; i++) {
			DataHandlerWrapper handler = result.getDataHandlerWrappers()[i];
			if(outputDirectory == null || outputDirectory.length() == 0){
				outputDirectory = ".";
			} else if(!(new File(outputDirectory)).exists()){
				(new File(outputDirectory)).mkdirs();
			}
			FileOutputStream outputStream = new FileOutputStream(new File(outputDirectory+"/"+handler.getName()));
			System.out.println("Writing "+outputDirectory+"/"+handler.getName());

			outputStream.write(handler.getDataHandler());
			outputStream.flush();
			outputStream.close();
		}
	}

	private static ExportServiceParams parseExportParams() {
		ExportServiceParams exportParam = new ExportServiceParams();

		if ("zip".equalsIgnoreCase(fileType)) {
			exportParam.setFileType(TypeEnum.ZIP);
		} else if ("warc".equalsIgnoreCase(fileType)) {
			exportParam.setFileType(TypeEnum.WARC_RESOURCE);
		} else if ("arc".equalsIgnoreCase(fileType)) {
			exportParam.setFileType(TypeEnum.ARC_RESOURCE);
		} else if(fileType != null && fileType.length() > 0){
			System.out.println("The requested file format is not supported");
			System.exit(EXIT_CODE_FAIL);
		}

		if (maxFileSize != null && maxFileSize.length() > 0) {
			try{
				exportParam.setMaxSize(Long.parseLong(maxFileSize));
			} catch(NumberFormatException e){
				System.out.println(maxFileSize + " is not an integer value.");
			}
		}
		if ("false".equalsIgnoreCase(compress)) {
			exportParam.setCompress(false);
		} else {
			exportParam.setCompress(true);
		}
		
		return exportParam;
	}

	private static void parseCommandLineOptions(String[] args) {
		addCommandLineOptions();

		CommandLineParser parser = new GnuParser();

		try {
			cmdLine = parser.parse(options, args);
		} catch (ParseException e) {
			System.err.println("Command line parsing failed.  Reason:"
					+ e.getMessage());
		}

		// If the user isn't asking for usage help, validate the given command
		// line options.
		if (!cmdLine.hasOption("help") && cmdLine.getOptions().length > 0) {
			if (cmdLine.hasOption("r")) {
				lockssUri = cmdLine.getOptionValue("r");
				System.out.println("Lockss box uri: " + lockssUri);
			}				
			if (cmdLine.hasOption("a")) {
				auId = cmdLine.getOptionValue("a");
				System.out.println("AU Id: " + auId);
			}			
			if (cmdLine.hasOption("f")) {
				auIdsFileList = cmdLine.getOptionValue("f");
				System.out.println("AU Ids file: " + auIdsFileList);
			}
			if (cmdLine.hasOption("o")) {
				outputDirectory = cmdLine.getOptionValue("o");
				System.out.println("Output directory: " + outputDirectory);
			}
			if (cmdLine.hasOption("u")) {
				userName = cmdLine.getOptionValue("u");
				System.out.println("Username: " + userName);
			}
			if (cmdLine.hasOption("p")) {
				password = cmdLine.getOptionValue("p");
			}
			if (cmdLine.hasOption("m")) {
				maxFileSize = cmdLine.getOptionValue("m");
				System.out.println("Max file size: " + maxFileSize);
			}
			if (cmdLine.hasOption("t")) {
				fileType = cmdLine.getOptionValue("t");
				System.out.println("Output file type: " + fileType);
			}
			if (cmdLine.hasOption("c")) {
				compress = cmdLine.getOptionValue("c");
				System.out.println("Compress data: " + compress);
			}
		} else {
			usage(options);
			System.exit(EXIT_CODE_SUCCESS);
		}
	}

	private static void addCommandLineOptions() {
		options = new Options();

		options.addOption("h", "help", false, "Display help");
		options.addOption(OptionBuilder
				.withArgName("string")
				.withLongOpt("URI")
				.hasArg()
				.withDescription(
						"The URI for the lockss box")
				.create("r"));		

		options.addOption(OptionBuilder
				.withArgName("string")
				.withLongOpt("auId")
				.hasArg()
				.withDescription(
						"Au Id for single AU to be exported.")
				.create("a"));		
		
		options.addOption(OptionBuilder
				.withArgName("file")
				.withLongOpt("inputfile")
				.hasArg()
				.withDescription(
						"An input file that has a list of AU Ids to be downloaded.")
				.create("f"));
		
		options.addOption(OptionBuilder
				.withArgName("directory")
				.hasArg()
				.withDescription(
						"The direcotyry of ARC/WARC file to be processed.")
				.withLongOpt("outputDir").create("o"));

		options.addOption(OptionBuilder
				.withArgName("username")
				.hasArg()
				.withDescription("Lockss box username").withLongOpt("username")
				.create("u"));

		options.addOption(OptionBuilder
				.withArgName("password")
				.hasArg()
				.withDescription("Lockss box password.")
				.withLongOpt("password").create("p"));

		options.addOption(OptionBuilder
				.withArgName("int")
				.hasArg()
				.withDescription("Max file size in MB.")
				.withLongOpt("maxFileSize").create("m"));

		options.addOption(OptionBuilder
				.withArgName("WARC|ARC|ZIP")
				.hasArg()
				.withDescription("Output file format.")
				.withLongOpt("fileType").create("t"));

		options.addOption(OptionBuilder
				.withArgName("boolean")
				.hasArg()
				.withDescription("Export compressed data.")
				.withLongOpt("compress").create("c"));}

	private static void usage(Options options) {
		HelpFormatter hf = new HelpFormatter();
		hf.printHelp(applicationName, options);
	}

}
