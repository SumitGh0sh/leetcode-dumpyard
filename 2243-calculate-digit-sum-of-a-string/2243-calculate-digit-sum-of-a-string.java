class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder s2 = new StringBuilder();
            int l= s.length();
            for(int i=0; i<l ; i+=k){
                String sub = s.substring(i,Math.min(i+k,l));
                int sum=0;
                for(int j=0; j<sub.length();j++){
                    sum+=sub.charAt(j) - '0';
                }
                s2.append(sum);
            }
            s=s2.toString();
        }
        return s;
    }
}