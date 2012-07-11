package Adder

import (
	"testing"
	"fmt"
)

const (
	GOROUTINES_NUM = 10
	COUNT_NUM      = 1000000
	ADD_NUM        = 1
)

func TestAdder(t *testing.T) {
	adder := new(Adder)
	
	routine := make(chan int)

	for i := 0; i < GOROUTINES_NUM; i++ {
		go func(routineNum int) {
			fmt.Println("Start routine: ", routineNum)
			for j := 0; j < COUNT_NUM; j++ {
				adder.Add(ADD_NUM)
			}
			routine <- routineNum
		}(i);
	}
	
	for i := 0; i < GOROUTINES_NUM; i++ {
		fmt.Println("End routine :", <- routine)
	}

	if adder.current_num != GOROUTINES_NUM * COUNT_NUM * ADD_NUM {
		t.Errorf("got %d expected %d", adder.current_num, GOROUTINES_NUM * COUNT_NUM * ADD_NUM)
	}
}
