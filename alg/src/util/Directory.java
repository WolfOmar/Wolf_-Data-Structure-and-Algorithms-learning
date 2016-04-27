package util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by aristark on 4/20/16.
 */
public final class Directory {
    public static File[]
    local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern;
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[]
    local(String path,final String regex){
        return local(new File(path),regex);
    }

    // A two-tuple for returning a pair of objects:
    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        //the default iterable element is the file list:
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString(){
//            for (File file:files){
//                System.out.println(file.getName()+"\n");
//            }
//
//            for (File file:dirs){
//                System.out.println(file.getName());
//            }
//            return "dirs: "+ dirs.toString()+"\n"+"files: "+files.toString()+"\n";
            return "dirs: "+PPrint.pformat(dirs)+"\n\nfiles: "+PPrint.pformat(files);

        }
    }

    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()){
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else{      //regular file
                if (item.getName().matches(regex)){
                    result.files.add(item);
                }

            }
        }
        return result;
    }

    public static TreeInfo
    walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo
    walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    public static void main(String[] args){
        System.out.println(walk("./","T.*"));
    }

}
