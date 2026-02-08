class Vowels {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int mid=n/2;
       return isVowel(0,mid,s)==isVowel(mid,n,s);
        
        
    }
    public int isVowel(int start,int end,String s){
            int count=0;
            for(int i=start;i<end;i++){
                char c1=s.charAt(i);
                if(c1=='a'||c1=='e'||c1=='i'||c1=='o'||c1=='u'||c1=='A'||c1=='E'|c1=='I'||  c1=='O'||c1=='U')
                count++;
            }
            return count;
        }
}