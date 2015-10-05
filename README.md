# WASLockssExport
Lockss Export Jar file to export data from Lockss box

Usage Information
```
> java -jar lockss_export-1.0-SNAPSHOT-jar-with-dependencies.jar
usage: LockssExportClient
 -a,--auId <string>             Au Id for single AU to be exported.
 -c,--compress <boolean>        Export compressed data.
 -f,--inputfile <file>          An input file that has a list of AU Ids to
                                be downloaded.
 -h,--help                      Display help
 -m,--maxFileSize <int>         Max file size in MB.
 -o,--outputDir <directory>     The direcotyry of ARC/WARC file to be
                                processed.
 -p,--password <password>       Lockss box password.
 -r,--URI <string>              The URI for the lockss box
 -t,--fileType <WARC|ARC|ZIP>   Output file format.
 -u,--username <username>       Lockss box username
```
 
Downloading the files
1) Prepare a list of AU Ids. You can find the superset for the AU Ids at All Title AUIDs and All AUIDs. 

2) Create a text file that lists all the AUIDs, one per line.
```
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~2
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~3
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~4
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~5
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~6
org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~7
```
3) Recommended command to export from file
```java -jar lockss_export-1.0-SNAPSHOT-jar-with-dependencies.jar -f auIds.txt -c true -m 1024 -o /export/data -u <Lockss username> -p <Lockss Password> -t WARC -r http://lockss-box.exmple.org:8081```

4) Recommended command to export a single AU
```java -jar lockss_export-1.0-SNAPSHOT-jar-with-dependencies.jar -a "org|lockss|plugin|highwire|HighWirePressH20Plugin&base_url~http%3A%2F%2Fasj%2Esagepub%2Ecom%2F&volume_name~7" -c true -m 1024 -o /export/data -u <Lockss username> -p <Lockss Password> -t WARC -r http://lockss-box.exmple.org:8081```

5) After finishing the download, you need to delete the files from the server manually. Go to http://lockss-box.exmple.org:8081/ExportContent and click "Delete Export Files" button.
