import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * CompressionUtil class to compress and decompress messages using the Deflate compression algorithm.
 * The Deflate algorithm is used here due to its effective balance between compression speed and efficiency,
 * making it suitable for applications needing real-time data transmission such as network communications.
 */
public class CompressionUtil {

    /**
     * Compresses a string into a byte array using Deflate compression algorithm.
     * @param data The string to compress.
     * @return A byte array containing the compressed data.
     * @throws Exception if an error occurs during compression.
     */
    public static byte[] compress(String data) throws Exception {
        // Convert the input string to byte array for compression using UTF-8 encoding
        byte[] input = data.getBytes("UTF-8");

        // Create a new Deflater object to perform the compression
        Deflater deflater = new Deflater();
        deflater.setInput(input); // Set the data to compress
        deflater.finish(); // Indicate that the data are ready to be compressed

        // Create a buffer to hold the compressed data temporarily
        byte[] buffer = new byte[1024];
        // Perform the compression, and get the size of the compressed data
        int compressedDataLength = deflater.deflate(buffer);

        // Create an output byte array to store the compressed data exactly
        byte[] output = new byte[compressedDataLength];
        // Copy the compressed data from the temporary buffer to the output array
        System.arraycopy(buffer, 0, output, 0, compressedDataLength);

        return output;
    }

    /**
     * Decompresses a byte array back into a string using Deflate compression algorithm.
     * @param data The compressed byte array to decompress.
     * @return The original string after decompression.
     * @throws Exception if an error occurs during decompression.
     */
    public static String decompress(byte[] data) throws Exception {
        // Create a new Inflater object to perform the decompression
        Inflater inflater = new Inflater();
        inflater.setInput(data); // Set the compressed data to decompress

        // Create a buffer to hold the decompressed data temporarily
        byte[] buffer = new byte[1024];
        // Inflate the compressed data and get the length of the decompressed data
        int resultLength = inflater.inflate(buffer);
        inflater.end(); // Close the inflater and release any resources

        // Convert the decompressed byte array back to string using UTF-8 encoding
        return new String(buffer, 0, resultLength, "UTF-8");
    }
}
