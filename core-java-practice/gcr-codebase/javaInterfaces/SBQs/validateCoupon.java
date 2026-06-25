interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

class ShoppingCart implements CouponValidator {
    private final String[] validCoupons = {"SAVE10", "FREESHIP", "WELCOME20", "BOGO50"};

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        for (String validCode : validCoupons) {
            if (validCode.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        String[] couponsToTest = {"SAVE10", "XYZ", "FREESHIP", "INVALIDCODE123", "BOGO50"};

        System.out.println("=== Coupon Validation Results ===");
        for (String coupon : couponsToTest) {
            if (cart.validateCoupon(coupon)) {
                System.out.println("Coupon '" + coupon + "' is VALID.");
            } else {
                System.out.println("Coupon '" + coupon + "' is INVALID.");
            }
        }
    }
}