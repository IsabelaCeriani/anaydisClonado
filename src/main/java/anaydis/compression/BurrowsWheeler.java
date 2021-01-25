package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BurrowsWheeler implements anaydis.compression.Compressor {
    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();
        while (str != null) {
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; ++i) {
                strs[i] = str.substring(i) + str.substring(0, i);
            }

            java.util.Arrays.sort(strs);

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strs.length; ++i) {
                builder.append(strs[i].charAt(strs[i].length() - 1));
            }
            builder.toString();
            str = br.readLine();
        }
    }


    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();
        while (str != null) {
            Integer[] indices = new Integer[str.length()];
            for (int i = 0; i < indices.length; ++i) {
                indices[i] = i;
            }
            java.util.Arrays.sort(indices, new BWComparator(str));

            int startIndex = 0;
            for (; str.charAt(startIndex) != '$'; ++startIndex) ;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < indices.length - 1; ++i) {
                startIndex = indices[startIndex];
                char c = str.charAt(startIndex);
                builder.append(c);
            }
            builder.toString();
            str = br.readLine();
        }
    }

    private static final class BWComparator implements java.util.Comparator<Integer> {
        private final String string;

        BWComparator(String string) {
            this.string = string;
        }

        @Override
        public int compare(Integer i, Integer j) {
            return string.charAt(i) - string.charAt(j);
        }

        public boolean equals(Integer i, Integer j) {
            return string.charAt(i) == string.charAt(j);
        }
    }
}
