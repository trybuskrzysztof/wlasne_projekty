import pqScan.BarcodeReader.jar;
import com.pqscan.barcodereader.BarcodeScanner;
import com.pqscan.barcodereader.BarCodeType;

public class ReadCode39Demo
{
    public static void main(String[] args)
    {
        try
        {
            // Java Barcode Scanner SDK will read Code 39 only from loaded Jpeg image source.
            BarcodeResult[] results = BarcodeScanner.Scan("C:/sample.jpg", BarCodeType.Code39);

            for(int i = 0; i < results.length; i++)
            {
                // Scanned and decoded Code 39 data characters will be output as array.
                System.out.println(results[i].getData() + "--" + results[i].getBarType());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}