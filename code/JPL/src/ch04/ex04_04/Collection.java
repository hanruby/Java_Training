package ch04.ex04_04;

/**
 * ex04_04 コレクションクラス階層の設計
 * 
 * Reference : http://java.sun.com/javase/ja/6/docs/ja/api/
 * @author ato
 */

/**
 * このインタフェースを実装すると、オブジェクトを「foreach」文の対象にすることができる。
 */
interface Iterable<T> {}

/**
 * 「コレクション階層」のルートインタフェース。
 * コレクションは、その「要素」であるオブジェクトのグループを表す。
 */
interface Collection<E> extends Iterable<E> {}

/**
 * リスト内のどこに各要素が挿入されるかを精密に制御できる。  
 */
interface List<E> extends Collection<E> {}

/**
 * 処理の前に要素を保持する。
 * キューにより、基本的な Collection オペレーションに加え、追加の挿入、抽出、および検査オペレーションが提供される。
 */
interface Queue<E> extends Collection<E> {}

/**
 * 両端で要素の挿入および削除をサポートする線形コレクション。 
 */
interface Deque<E>  extends Queue<E> {}

/**
 * 重複要素のないコレクション。
 * 数学で言う集合の抽象化オブジェクトをモデル化する。
 */
interface Set<E> extends Collection<E> {}

/**
 * 要素に対して「全体順序付け」を追加提供する。 
 */
interface SortedSet<E> extends Set<E> {}

/**
 * 指定されたターゲットにもっとも近い要素を報告する。
 */
interface NavigableSet<E> extends SortedSet<E> {}

