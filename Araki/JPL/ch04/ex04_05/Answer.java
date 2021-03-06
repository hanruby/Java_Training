package ch04.ex04_05;

/**
 * ex04_05 Q. (a)(b)(c)(d)は、インタフェース、抽象クラス、具象クラスのどれで表現すべきか。 
 */

interface インタフェース {}

abstract class 抽象クラス {
    public abstract void 抽象メソッド();
    public void メソッド() {
        // 中身
    }
}

class 具象クラス {
    public void メソッド() {
        // 中身
    }
}

/*
 * (a) N分木のノードを表す TreeNode
 *  A. 抽象クラス
 *  理由：
 *   - 同じ振る舞いをするメソッドを定義しておくと便利。
 *   - ノードに格納するものが異なる振る舞いをするような実装はないはず。
 */

/*
 * (b) 特定の順番（深さ優先、幅優先など）で木を探索する TreeWalker
 *  A. 抽象クラス
 *  理由：
 *   - 探索のしくみはデフォルトで提供すべき
 *   - 順序付けの仕組みについては実装できるようにしておく
 */

/* 
 * (c) グラフィックシステムにより描画可能なオブジェクトのための Drawable
 *  A. インタフェース
 *  理由：
 *   - 描画の仕方の実装は自由度があっていい。
 */

/*
 * (d) グラフィックデスクトップから実行出来るプログラムのための Application
 *  A. インタフェース
  *   - 幅を持たせるためにインタフェースにすべき。
 */
