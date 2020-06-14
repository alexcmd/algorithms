package learn.strings;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if (K==0 || S ==null)
            return null;
        if (S.isEmpty())
            return "";
        int n = S.length();
        int delimiter_counter=0;
        StringBuilder builder = new StringBuilder();
        for (int i=n-1; i>=0;i--){
            char c = S.charAt(i);
            if (c=='-'){
                continue;
            }

            delimiter_counter++;
            if (c>='a'&& c<='z')
                c = (char)( 'A' + (c-'a'));

            builder.append(c);

            while (i>0 && S.charAt(i-1)=='-')
                i--;

            if (builder.length()>0 && delimiter_counter==K && i>0) {
                builder.append('-');
                delimiter_counter=0;
            }


        }

        return builder.reverse().toString();

    }
}
