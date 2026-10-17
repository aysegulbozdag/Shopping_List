package com.app.shoppinglist.data


//sealed class yapısı gereği dışarıdan doğrudan new anahtar kelimesiyle
// türetilemez ve abstract (soyut) bir sınıftır.
// Ancak alt sınıflarının (subclasses) ortaklaşa kullanacağı özellikleri
// veya verileri barındırmak için constructor parametresi alabilir.
// Alt sınıflar kendilerini tanımlarken, üst sınıfın bu parametresini
// doldurmak zorundadır.
sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home")
    data object BasketScreen : Screen("basket")
}