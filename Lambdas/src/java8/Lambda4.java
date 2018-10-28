package java8;
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(outerNum);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(outerStaticNum);
        };
        
        
        System.out.println(stringConverter1.convert(44));
        System.out.println(stringConverter2.convert(44));
        
    }
}