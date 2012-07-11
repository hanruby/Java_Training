package Adder

import (
	//"fmt"
	)

type Adder struct {
	current_num int
}

func (adder *Adder) Add (num int) {
	adder.current_num = adder.current_num + num
	//fmt.Println(adder.current_num)
}

