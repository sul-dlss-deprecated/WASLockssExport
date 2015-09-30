package org.lockss.ws.export;

public class ExportServiceProxy implements org.lockss.ws.export.ExportService {
  private String _endpoint = null;
  private org.lockss.ws.export.ExportService exportService = null;
  
  public ExportServiceProxy() {
    _initExportServiceProxy();
  }
  
  public ExportServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initExportServiceProxy();
  }
  
  private void _initExportServiceProxy() {
    try {
      exportService = (new org.lockss.ws.export.ExportServiceImplServiceLocator()).getExportServiceImplPort();
      if (exportService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)exportService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)exportService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (exportService != null)
      ((javax.xml.rpc.Stub)exportService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.lockss.ws.export.ExportService getExportService() {
    if (exportService == null)
      _initExportServiceProxy();
    return exportService;
  }
  
  public org.lockss.ws.export.ExportServiceWsResult createExportFiles(org.lockss.ws.export.ExportServiceParams arg0) throws java.rmi.RemoteException, org.lockss.ws.export.LockssWebServicesFaultInfo{
    if (exportService == null)
      _initExportServiceProxy();
    return exportService.createExportFiles(arg0);
  }
  
  
}