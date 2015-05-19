package org.fcrepo.migration.idmappers;

public class WordCheckerIDMapper extends SimpleIDMapper {

    public WordCheckerIDMapper(final String baseUrl, final String rootPath) {
	 	super(baseUrl, rootPath);
	 }

	 protected String pidToPath(final String pid) {
		 String[] tSplitPid = pid.split(":");
		 if (tSplitPid[1].matches("[0-9]+")) {
			 return super.pidToPath(pid);
		 } else {
			 final StringBuffer path = new StringBuffer();
			 path.append(rootPath);
			 if (!rootPath.endsWith("/")) {
				 path.append("/");
			 }
			 path.append(tSplitPid[0]);
			 path.append('/');
			 path.append(tSplitPid[1]);
			 return path.toString();
		 }
    }
}
