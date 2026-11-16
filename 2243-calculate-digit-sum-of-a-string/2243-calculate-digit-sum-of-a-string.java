class Solution {
    public String digitSum(String s, int k) {
        int l= s.length();
        while(l>k){
            String s2="";
            for(int i=0; i<l ; i+=k){
                String sub = s.substring(i,Math.min(i+k,l));
                int sum=0;
                for(int j=0; j<sub.length();j++){
                    sum+=sub.charAt(j) - '0';
                }
                s2=s2+sum;
            }
            l=s2.length();
            s=s2;
        }
        return s;
    }
}