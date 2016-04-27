package util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by aristark on 4/20/16.
 */
public class DirList {
    public static void main(final String[] args){
        final File path = new File("./alg/src/util");
        String[] list;
        if (args.length == 0){
            list = path.list();
        }else {
//            list = path.list(new DirFilter(args[0]));
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);

        for (String dirItem : list){
            System.out.println(dirItem);
        }


    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
