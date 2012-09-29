package practice.ch22_03_Observer;

import java.util.Observable;
import java.util.Observer;

import practice.ch22_03_Observer.Users.UserState;

public class Eye implements Observer {
    Users watching;

    public Eye(Users users) {
        watching = users;
        watching.addObserver(this);
    }
    public void update(Observable users, Object whichState)
    {
        if (users != watching)
            throw new IllegalArgumentException();

        UserState state = (UserState) whichState;
        if (watching.loggedIn(state))   // ユーザーがログインした
            addUser(state);             // リストに追加
        else
            removeUser(state);          // リストから除く
    }

    // ...
    private void removeUser(UserState state) {
        // TODO Auto-generated method stub
        
    }

    private void addUser(UserState state) {
        // TODO Auto-generated method stub
        
    }
}
