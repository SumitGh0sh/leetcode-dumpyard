class Solution {
    public boolean canAliceWin(int n) {
        int remove=10;
        boolean turn = true; //alice ka turn
        while(n>=remove){
            n-=remove;
            remove--;
            turn=!turn;
        }
        //jo current player rahega vo haara hoga
        //so winner just previous player hoga
        return !turn;
    }
}