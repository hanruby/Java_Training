
演習問題
========

`P.570`

現状では、readCSVTableは、それが期待する入力形式に関して、厳格すぎると同時に寛容すぎます。
入力の終わりに空行があると、IOExceptionをスローしますので、厳格すぎます。
４つ以上のカンマを持つ行でも、例外が発生しませんので、寛容すぎます。
この両方の問題を修正しなさい。

