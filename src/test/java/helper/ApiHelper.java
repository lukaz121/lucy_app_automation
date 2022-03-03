package helper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ApiHelper {
    public Response kycAction(KycDocument kycDoc) throws IOException {
       Response check = new Response();
       String imageCheckBase64 = getImageBase64(kycDoc.imageCheckName);
        check.data = kycDoc;
        if (imageCheckBase64.equals(kycDoc.idCardFront)) {
            check.statusCode = 200;
        } else {
            check.statusCode = 400;
        }
        return check;
    }

    public String getImageBase64(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader
                .getResource(fileName)
                .getFile());
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(inputFile));
    }
}
