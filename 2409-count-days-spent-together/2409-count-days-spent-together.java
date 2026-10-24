class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        String[] Aarriveparts = arriveAlice.split("-");
        int aliceArrivingday = days[Integer.parseInt(Aarriveparts[0])] + Integer.parseInt(Aarriveparts[1]);
        String[] Aleaveparts = leaveAlice.split("-");
        int aliceLeavingday = days[Integer.parseInt(Aleaveparts[0])] + Integer.parseInt(Aleaveparts[1]);
        String[] Barriveparts = arriveBob.split("-");
        int bobArrivingday = days[Integer.parseInt(Barriveparts[0])] + Integer.parseInt(Barriveparts[1]);
        String[] Bleaveparts = leaveBob.split("-");
        int bobleavingday = days[Integer.parseInt(Bleaveparts[0])] + Integer.parseInt(Bleaveparts[1]);
        
        int arrive = Math.max(aliceArrivingday, bobArrivingday);
        int leave = Math.min(aliceLeavingday, bobleavingday);
        /**if(arrive <= leave){
            return leave - arrive + 1;
        }else{
            return 0;
        }
        */
        return Math.max(0, leave - arrive + 1);
    }
    public static void main(String[] args){
        Solution sc = new Solution();
        System.out.println(sc.countDaysTogether("7-17","08-19", "07-25", "08-15"));
    }
}
