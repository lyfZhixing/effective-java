package chapter4.heterogeneous;

public class FavoritesMain {

    public static void main(String[] args) throws NoSuchMethodException {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "abc");
        favorites.putFavorite(Integer.class, 43);
        favorites.putFavorite(Class.class, Favorites.class);
        String favoriteString = favorites.getFavorite(String.class);
        int favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString,favoriteInteger, favoriteClass.getName());
    }

}
