package ch20.ex20_06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OperatorTokenizer {

    protected Map<String, Double> operations = new HashMap<String, Double>();
    
    enum Operator {
        PLUS('+') {
            @Override
            public double calc(double left, double right) {
                return left + right;
            }
        },
        MINUS('-') {
            @Override
            public double calc(double left, double right) {
                return left - right;
            }
        },
        EQUAL('=') {
            @Override
            public double calc(double left, double right) {
                return right;
            }
        };
        
        private char op;
        
        private Operator(char op) {
            this.op = op;
        }
        
        public abstract double calc(double left, double right);
        
        @Override
        public String toString() {
            return String.valueOf(this.op);
        }
        
        public Character toChar() {
            return this.op;
        }
         
        private static final Map<Character, Operator> lookup = new HashMap<Character, Operator>();
        static {
            for (Operator operator : Operator.values())
                lookup.put(operator.toChar(), operator);
        }

        public static Operator get(Character op) {
            return lookup.get(op);
        }
    }
    
    public void readOperation(Reader source) throws IOException {
        double value = 0.0;
        String name = null;
        Operator operator = null;
                
        ExpressionState state = ExpressionState.reset();
        
        StreamTokenizer in = new StreamTokenizer(source);
        
        in.commentChar('#');  // コメント文字を'#'にする
        in.ordinaryChar('/'); // '/'をコメント文字でなくす
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // もし、単語だったら:
            if (in.ttype == StreamTokenizer.TT_WORD) {
                // 変数名
                if (state == ExpressionState.NAME) {
                    name = in.sval;
                    state = state.next();
                }
                // 値
                if (state == ExpressionState.VALUE) {
                    String key = in.sval;
                    double leftVal = 0.0;
                    double rightVal = 0.0;
                    
                    try {
                        leftVal = operations.get(name);
                    } catch (Exception e) {
                        // キーが見つからなかったら 0 にする
                        leftVal = 0.0;
                    }
                    
                    try {
                        rightVal = operations.get(key);
                    } catch (Exception e) {
                        // キーが見つからなかったら 0 にする
                        rightVal = 0.0;
                    }
                    
                    operations.put(name, operator.calc(leftVal, rightVal));
                                        
                    state = state.next();
                }
            } 
            // もし、数値だったら
            else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                // 値
                if (state == ExpressionState.VALUE) {
                    value = in.nval;
                                 
                    double leftVal = 0.0;
                    try {
                        leftVal = operations.get(name);
                    } catch (NullPointerException e) {
                        // キーが見つからなかったら 0 にする
                        leftVal = 0.0;
                    }
                    double rightVal = value;
                    
                    operations.put(name, operator.calc(leftVal, rightVal));
                    
                    state = state.next();
                } else {
                    throw new IOException("misplaced value");
                }
            }
            // 演算子
            else if (state == ExpressionState.OPERATION) {
                Character opchar = (char)in.ttype;
                operator = Operator.get(opchar);
                if (operator == null ) {
                    throw new IOException("Operator incorrect");    
                }
                state = state.next();
            }
        }
    }
    
    /**
     * 式の遷移を表す 
     */
    protected enum ExpressionState {
        // FIXME: 状態にアクションを含めるほうがいいかも
        NAME {
            @Override
            public ExpressionState next() {
                return OPERATION;
            }
        },
        OPERATION {
            @Override
            public ExpressionState next() {
                return VALUE;
            }
        },
        VALUE {
            @Override
            public ExpressionState next() {
                return NAME;
            }
        };
        
        public abstract ExpressionState next();
        public static ExpressionState reset() {
            return NAME;
        }
    }
    
    public void printOperations() {
        for (Entry<String, Double> operator : operations.entrySet()) {
            System.out.printf("%s:%f%n",operator.getKey(), operator.getValue());
        }
    }
}
