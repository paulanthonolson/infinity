package cscmatch;

public class Compatibility implements Comparable<Compatibility> {
    private Member otherMbr;
    private int score;

    public Compatibility(Member myMbr, Member otherMbr) {
        this.otherMbr = otherMbr;
        this.score = 0;

        for (Interest myInterest : myMbr) {
            boolean isInterestFound = false;
            for (Interest otherInterest : otherMbr) {
                if (myInterest.getTopic().equals(otherInterest.getTopic())) {
                    this.score += myInterest.getLevel() * otherInterest.getLevel();
                    isInterestFound = true;

                }
            }
            if (!isInterestFound) {

            }
        }

        for (Interest otherInterest : otherMbr) {
            boolean isInterestFound = false;
            for (Interest myInterest : myMbr) {
                if (otherInterest.getTopic().equals(myInterest.getTopic())) {
                    isInterestFound = true;

                }
            }
            if (!isInterestFound) {

                this.score += otherInterest.getLevel() / 2;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public Member getOtherMbr() {

        return otherMbr;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(otherMbr + ", " + score + "\n");
        return result.toString();
    }

    public int compareTo(Compatibility otherCmpt) {
        int scoreCompare;

        if (this.score < otherCmpt.score) {
            scoreCompare = -1;
        } else if (this.score > otherCmpt.score) {
            scoreCompare = 1;
        } else {
            scoreCompare = 0;
        }
        if (scoreCompare != 0) {
            return scoreCompare;
        }
        return this.otherMbr.getName().compareToIgnoreCase(otherCmpt.otherMbr.getName());
    }

}
