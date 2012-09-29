package practice.ch22_03_Observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Users extends Observable {

    private Map<String, UserState> loggedIn = new HashMap<String, UserState>();

    public void login(String name, String password) throws BadUserException {
        if (!passwordValid(name, password))
            throw new BadUserException(name);

        UserState state = new UserState(name);
        loggedIn.put(name, state);
        setChanged();
        notifyObservers(state);
    }

    public void logout(UserState state) {
        loggedIn.remove(state.name());
        setChanged();
        notifyObservers(state);
    }

    // ...
    private boolean passwordValid(String name, String password) {
        // TODO Auto-generated method stub
        return false;
    }


    @SuppressWarnings("serial")
    public class BadUserException extends Exception {

        public BadUserException(String name) {
            // TODO Auto-generated constructor stub
        }

    }

    public class UserState {

        public UserState(String name) {
            // TODO Auto-generated constructor stub
        }

        public Object name() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public boolean loggedIn(UserState state) {
        // TODO Auto-generated method stub
        return false;
    }

}