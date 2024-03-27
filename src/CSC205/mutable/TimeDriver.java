package mutable;

public class TimeDriver {
    public static void main(String[] args) {
        MutableTime mutable6am;
        MutableTime mutable7am;

        mutable6am = new MutableTime(6, 0);
        mutable7am = mutable6am;
        mutable7am.addHour(1);

        System.out.println("Mutable objects directly manipulate their own state");
        System.out.println("mutable6am: " + mutable6am);
        System.out.println("mutable7am: " + mutable7am);
        System.out.println("Notice how both became 07:00 since they reference the same object");

        ImmutableTime immutable6am;
        ImmutableTime immutable7am;

        immutable6am = new ImmutableTime(6, 0);
        immutable7am = immutable6am;
        immutable7am.addHour(1);

        System.out.println("Immutable objects never directly manipulate their own state");
        System.out.println("immutable6am: " + immutable6am);
        System.out.println("immutable7am: " + immutable7am);
        System.out.println("Notice how both remained 06:00 since addHour does not change the existing object");

        immutable6am = new ImmutableTime(6, 0);
        immutable7am = immutable6am.addHour(1);

        System.out.println("Immutable objects typically return a new object for things that require change");
        System.out.println("immutable6am: " + immutable6am);
        System.out.println("immutable7am: " + immutable7am);
        System.out.println("This time, we capture the value returned from addHour which is the new changed value");

        ImmutableTime immutable730am;

        immutable730am = immutable6am.addHour(1).addMinute(30);

        System.out.println("Immutable objects normally support chaining by their design");
        System.out.println("immutable730am: " + immutable730am);

        ChainableMutableTime chainableMutable6am;
        ChainableMutableTime chainableMutable730am;

        chainableMutable6am = new ChainableMutableTime(6, 0);
        chainableMutable730am = chainableMutable6am.addHour(1).addMinute(30);

        System.out.println("Mutable objects can be made chainable by having them return 'this'");
        System.out.println("chainableMutable6am: " + chainableMutable6am);
        System.out.println("chainableMutable730am: " + chainableMutable730am);
        System.out.println("but the original problem that both changed remains");
    }
}
