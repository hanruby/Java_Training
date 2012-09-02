package ch20.ex20_06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class OperatorTokenizer {

    private Map<String, Integer> operation = new HashMap<String, Integer>();
    
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
    }
    
    public void readOperation(Reader source) throws IOException {
        double value = 0.0;
        String name = null;
        String op = null;
        
        StreamTokenizer in = new StreamTokenizer(source);
        
        in.commentChar('#');  // コメント文字を'#'にする
        in.ordinaryChar('/'); // '/'をコメント文字でなくす
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            // もし、単語だったら:
            if (in.ttype == StreamTokenizer.TT_WORD) {
                if (name == null) {
                    name = in.sval;
                } else {
                    op = in.sval;
                }
            } 
            // もし、数値だったら
            else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                if (name == null || op == null) {
                    throw new IOException("misplaced");
                } else {
                    switch(in.ttype) {
                        
                    }
                    value = in.nval;
                }
            }
        }
    }
    
    private enum Expression {
        NAME {
            @Override
            public void next() {
                // TODO Auto-generated method stub
                
            }
        },
        OPERATION {
              @Override
            public void next() {
                // TODO Auto-generated method stub
                
            }
        },
        VALUE {
            @Override
            public void next() {
                // TODO Auto-generated method stub
                
            }
        };
        
        public abstract void next(); 
    }
    
}
