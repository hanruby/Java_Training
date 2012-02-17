import java.io.FileInputStream;
import java.io.IOException;

class BadDataSetException extends Exception{ // Question: なんで警告がでるのか？
	public String file;
    public IOException e;
    
    public BadDataSetException(IOException e, String file) {
    	super("File name : " + file + " exception found");
    	this.file = file;
    	this.e = e;
	}
}

class MyUtilities {
	public double [] getDataSet(String setName)
		throws BadDataSetException
		{
			String file = setName + ".dset";
			FileInputStream in = null;
			try {
				in = new FileInputStream(file);
				return readDataSet(in);	
			} 
			catch(IOException e) {
				throw new BadDataSetException(e, file);
			}
			finally {
				try {
					if (in != null) {
						in.close();
					}
				}
				catch (IOException e) {
					; // ignore
				}
			}
		}

	private double[] readDataSet(FileInputStream in) {
		// TODO Implement
		try {
			in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
