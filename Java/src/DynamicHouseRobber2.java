class    DynamicHouseRobber2{
    public int rob(int[] items) {
        
        int temp = 0;
        int rob1 = 0;
        int rob2 = 0;
        int temp1 = 0;
        if(items.length<=1){
            return items[0];
        }

        for(int i = 0; i<items.length-1; i++) {
            temp = Math.max(rob1, items[i]+rob2);
            rob2 = rob1;
            rob1 = temp;
        }
        rob1 = 0;
        rob2 = 0;
        for(int i = 1; i<items.length; i++) {
            temp1 = Math.max(rob1, items[i]+rob2);
            rob2 = rob1;
            rob1 = temp1;
        }
        
        return Math.max(temp, temp1);
        
        }
    }
