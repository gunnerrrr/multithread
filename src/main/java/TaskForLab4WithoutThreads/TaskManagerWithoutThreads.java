package TaskForLab4WithoutThreads;

import TaskLab4.MyThread;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManagerWithoutThreads {
    private static int countOfSubDirectories = 0;
    private static int countOfBigFiles = 0;
    private static int countOfMathFiles = 0;

    private Pattern p;
    private Matcher m = null;

    public void setP(Pattern p) {
        this.p = p;
    }

    public static int getCountOfSubDirectories() {
        return countOfSubDirectories;
    }

    public static int getCountOfBigFiles() {
        return countOfBigFiles;
    }

    public static int getCountOfMathFiles() {
        return countOfMathFiles;
    }



    private synchronized boolean accept(String name) {
        if (p == null) {
            return true;
        }
        m = p.matcher(name);
        if (m.matches()) {
            return true;
        }
            return false;
    }

    public synchronized void calculateCountOfSubDirectories(File file) {
        File[] list = file.listFiles();
        if (list != null)
            for (File fil : list) {
                if (fil.isDirectory()) {
                    System.out.println(true);
                    countOfSubDirectories++;
                    calculateCountOfSubDirectories(fil);
                }

            }
    }



    public synchronized void calculateCountOfBigFiles(double size, File file) {
        File[] list = file.listFiles();
        if (list != null)
            for (File fil : list) {
                if (fil.length() > size) {
                    countOfBigFiles++;
                }
                if (fil.isDirectory()) {
                   // System.out.println(true);
                    calculateCountOfBigFiles(size, fil);
                }

            }
    }

    public synchronized void SearchByPattern(File topDirectory) {
        File[] list = topDirectory.listFiles();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getName());

            if (list[i].isDirectory()) {
                if (accept(list[i].getName())) {
                    countOfMathFiles++;

                }
                SearchByPattern(list[i]);

            }
            else {
                if (accept(list[i].getName())) {
                    countOfMathFiles++;
                }
            }
        }
    }
}

