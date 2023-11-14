package christmas.model;

import static christmas.OutputView.OutputViewMessage.BADGE_SANTA;
import static christmas.OutputView.OutputViewMessage.BADGE_STAR;
import static christmas.OutputView.OutputViewMessage.BADGE_TREE;
import static christmas.OutputView.OutputViewMessage.NO_BENEFIT;

public class Badge {

    private final int MIN_SANTA = 20000;
    private final int MIN_TREE = 10000;
    private final int MIN_STAR = 5000;
    private final String badge;


    public Badge(int totalDiscount) {
        int Totalpositive = -1 * totalDiscount;
        this.badge = giveBadge(Totalpositive);
    }

    private String giveBadge(int totalDiscount) {
        if (totalDiscount >= MIN_SANTA)
            return BADGE_SANTA.getForm();
        if (totalDiscount >= MIN_TREE) {
            return BADGE_TREE.getForm();
        }
        if (totalDiscount >= MIN_STAR) {
            return BADGE_STAR.getForm();
        }
        return NO_BENEFIT.getForm();
    }

    public String getBadge() {
        return badge;
    }


}
