package project.SuperCinema.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtilImpl implements FileUtil{
    @Override
    public String getFileTextFormat(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
