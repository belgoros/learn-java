package com.sca.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by c59scam on 12/08/2015.
 */
public enum CardVisual {
    IC_BNP_NET("ic-bnp-net", "001"),
    IC_INFINITE("ic-infinite", "002"),
    IC_PREMIER("ic-premier", "003"),
    IC_VISA("ic-visa", "004"),
    IC_CIRUS("ic-cirus", "999"),
    IC_PLUS("ic-plus", "999"),
    IC_JEUNE("ic-jeune", "999"),
    IC_LIVRET("ic-livret", "999"),
    UNKNOWN("UNKNOWN", "UNKNOWN");

    /**
     * Map containing CardVisual groups and makes it possible to get the
     * CardVisual by its goal value
     */
    private static final Map<String, CardVisual> MAP_BY_GOAL_VALUE = new HashMap<String, CardVisual>();

    /**
     * Initialization of the MAP_BY_CODE Map
     */
    static {
        for (final CardVisual cardVisual : values()) {
            MAP_BY_GOAL_VALUE.put(cardVisual.goalValue, cardVisual);
        }
    }

    /**
     * Card code to apply
     */
    private final String code;

    /**
     * GOAL value
     */
    private final String goalValue;

    /**
     * Constructor
     *
     * @param goalValue GOAL value
     * @param code      code to apply
     */
    CardVisual(final String goalValue, final String code) {
        this.goalValue = goalValue;
        this.code = code;
    }

    /**
     * Gets the CardVisual by goalValue
     *
     * @param goalValue - CardVisual goalValue
     * @return CardVisual
     */
    public static CardVisual getByGoalValue(final String goalValue) {
        final CardVisual cardVisual = MAP_BY_GOAL_VALUE.get(goalValue);
        if (cardVisual == null) {
            return UNKNOWN;
        }
        return cardVisual;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the goalValue
     */
    public String getGoalValue() {
        return goalValue;
    }
}
