package ch20.ex20_06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class OperatorTokenizer {

    private Map<String, Double> operation = new HashMap<String, Double>();
    
    enum Operator {
        PLUS('+') {
            @Override
            public int calc(int left, int right) {
                return left + right;
            }
        },
        MINUS('-') {
            @Override
            public int calc(int left, int right) {
                return left - right;
            }
        },
        EQUAL('=') {
            @Override
            public int calc(int left, int right) {
                return right;
            }
        };
        
        private char op;
        
        private Operator(char op) {
            this.op = op;
        }
        
        public abstract int calc(int left, int right);
        
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
        Operator operator ;
                
        ExpressionState state = ExpressionState.reset();
        
        StreamTokenizer in = new StreamTokenizer(source);
        
        in.commentChar('#');  // コメント文字を'#'にする
        in.ordinaryChar('/'); // '/'をコメント文字でなくす
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            System.out.println(String.valueOf(in.ttype));
            // もし、単語だったら:
            if (in.ttype == StreamTokenizer.TT_WORD) {
                if (state == ExpressionState.NAME) {
                    name = in.sval;
                    state = state.next();
                }
            } 
            // もし、数値だったら
            else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                if (state == ExpressionState.VALUE) {
                    value = in.nval;
                    operation.put(name, value);
                    //operation.get(name);
                    state = state.next();
                } else {
                    throw new IOException("misplaced value");
                }
            }
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
    
    protected enum ExpressionState {
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
        
    }
}
