package ch03.ex03_07;

public class ScreenColor {

    // I refer to Tiger P.62
    private enum Color {
        RED("red", 0xFF0000),
        GREEN("green", 0x00FF00),
        BLUE("blue", 0x0000FF),
        TRANSPARENT("transparent",0xFF000000);

        private final String name;
        private final int code;
        
        private Color(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String toString() {
            return this.name;
        }
        
        public String getName() {
            return this.name;
        }
        
        public int getCode() {
            return this.code;
        }
    }
    
    private Color color;
    
    /**
     * 色記述をScreenColorオブジェクトへ変換するのは、コストが高いため、コンストラクタで一度だけおこなう
     * @param name
     */
	public ScreenColor(Object name) {
	    if(name == null) {
	        throw new IllegalArgumentException();
	    }
	    for (Color color : Color.values()) {
            if (color.getName() == name.toString()) {
                this.color = color;
            }
        }
	}
	
	public String toString() {
	    return this.color.name;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScreenColor other = (ScreenColor) obj;
        if (color.getCode() != other.color.getCode())
            return false;
        return true;
    }

}
