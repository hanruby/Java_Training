package ch09.ex09_04;

/* P.192 */

/* *****************************************
 * 優先順位の高い方から低い方への演算子のリスト
 * *****************************************
 * 後置演算子     : [] . (params) expr++ expr--
 * 単項演算子     : ++expr --expr +expr -expr ~ !
 * 生成とキャスト : new (type)expr
 * 乗法           : * / %
 * 加法           : + -
 * シフト         : << >> >>>
 * 関係           : < > >= <= instanceof
 * 等値           : == !=
 * 積             : &
 * 排他的和       : ^
 * 和             : |
 * 条件積         : &&
 * 条件和         : ||
 * 条件           : ?:
 * 代入           : = += -= *= /= %= >>= <<= >>>= &= ^= |=
 */

public class Calculate {
    public static void main(String[] args) {
        int i = 3;
        
        System.out.println( 
                3 << 2L - 1 /*
                3 <<    1
                   6
                int OR long ?
                */
        );
        System.out.println(
                (3L << 2) - 1 /*
                    12    - 1
                          11
                int OR long ?
                */ 
        ); 
        System.out.println( 
                10 < 12 == 6 > 17 /*
                  true  ==  false
                      false
                boolean
                */ 
        );
        System.out.println(
                10 << 12 == 6 >> 17 /*
                0101000000000000 == 0110000000000000000
                                false
                boolean
                */ 
        ); 
        System.out.println(
                13.5e-1 % Float.POSITIVE_INFINITY /*
                  1.35  % Float.POSITIVE_INFINITY
                      1.35
                float
                */ 
        );
        System.out.println( 
                Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY /*
                     Infinity           +     - Infinity
                                     NaN
                 */
        );
        System.out.println( 
                Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY /*
                       Infinity          -       - Infinity
                                    Infinity
                */ 
        );
        System.out.println(
                0.0 / -0.0 == -0.0 / 0.0 /*
                  -NaN     ==     NaN
                          false
                boolean  
                */ 
        );
        System.out.println(
                Integer.MAX_VALUE + Integer.MIN_VALUE  /*
                      0x7FFFFFFF  +   0x80000000
                              0xFFFFFFFF
                                 -1  
                int
                */
        );
        System.out.println( 
                Long.MAX_VALUE + 5  /*
                0x7FFFFFFFFFFFFFFF + 5
                          0x8000000000000004
                          -9223372036854775808 + 4
                          -9223372036854775804
                long
                */
        );
        System.out.println(
                (short) 5 * (byte) 10  /*
                          50
                short
                */ 
        );
        System.out.println( 
                (i < 15 ? 1.72e3f : 0) /*
                    1.72e3f
                    1720
                int ?
                */
        );
        System.out.println(
                i++ + i++ + --i  /*
                 4  +  4  + --i
                 4  +  4  +  3
                11
                int
                */ 
        );
    }    
}
