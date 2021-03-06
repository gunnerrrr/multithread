package TaskForLab4WithoutThreads;


import java.io.File;
import java.nio.file.Paths;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Pattern pattern= Pattern.compile(".+jpg$");
        File file=new File(String.valueOf(Paths.get("/Users/mac/Desktop/re/Users/max/Samsung")));
        double maxSize=100000000;

        TaskManagerWithoutThreads taskManager = new TaskManagerWithoutThreads();
        taskManager.setP(pattern);
        taskManager.calculateCountOfSubDirectories(file);
        taskManager.calculateCountOfBigFiles(maxSize,file);
        taskManager.SearchByPattern(file);


        System.out.println(TaskManagerWithoutThreads.getCountOfSubDirectories()+" "+
                TaskManagerWithoutThreads.getCountOfBigFiles()+" "+
                TaskManagerWithoutThreads.getCountOfMathFiles());

//        taskManager.calculateCountOfSubDirectories(file);
//        taskManager.calculateCountOfBigFiles(1000000000,file);
//        taskManager.setP(pattern);
//        taskManager.SearchByPattern(file);
//        FindFile ff = new FindFile();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the file to be searched.. " );
//        String name = scan.next();
//        System.out.println("Enter the directory where to search ");
//        String directory = scan.next();
//        ff.findFile(name,new File(directory));
    }

    }

