package Greedy;

public class LemonadeStand {
    public boolean lemonadeChange(int[] bills) {
        int[] balance = new int[2];

        for(int bill : bills) {
            if (bill == 5) {
                balance[0]++;
            }

            if (bill == 10) {
                if (balance[0] >= 1) {
                    balance[0]--;
                    balance[1]++;
                }
                else
                    return false;
            }

            if (bill == 20) {
                if (balance[1] >= 1 && balance[0] >= 1) {
                    balance[1]--;
                    balance[0]--;
                }
                else if (balance[0] >= 3) {
                    balance[0] -= 3;
                }
                else
                    return false;
            }
        }

        return true;
    }
}
