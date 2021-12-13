SELENIUM PYTHON AUTOMATIC TESTS:

CHROME TESTS:

TEST 1:

Założenia:
Chcemy sprawdzić na portalu trojmiasto.pl jakie są aktualne ogłoszenia o pracę firmy Intel
    
Kroki:
1. Wchodzimy na stronę trojmiasto.pl
2. Wpisujemy w wyszukiwanie praca
3. Wybieramy widoczne na ekranie "Serwis Praca"
4. Wpisujemy pod napisem "Pracodawcy w Trójmieście" frazę "Intel" i klikamy "szukaj"
5. Wciskamy na przycisk pod adresem firmy z ilością dostępnych prac

Oczekiwany wynik:
Wyświetlona lista dostępnych ogłoszeń pracy od Intela

TEST 2:
Założenia:
Chcemy sprawdzić aktualny skład zespołu Natus Vincere na portalu hltv.org

Kroki:
1. Wchodzimy na stronę hltv.org
2. Wpisujemy w górnym pasku w miejsu gdzie występuje napis placeholderowy "Search..." frazę "Natus Vincere"
3. Wybieramy pierwszą dostępną opcję z listy
4. Obok opcji pośrodku ekranu "Info" wybieramy opcję "Roster"

MOZILLA TESTS:

TEST 1:

Założenia:
Chcemy otrzymać informację o błędnym loginie lub haśle na stronie logowania do serwisu wykop.pl

Kroki:
1. Wchodzimy na stronę wykop.pl
2. W prawym górnym rogu klikamy przycisk "Zaloguj się"
3. W pole loginu wpisujemy "dziki dzik"
4. W pole hasła wpisujemy "12345678" oraz klikamy "ENTER" lub przycisk "Zaloguj się"
5. Otrzymujemy informację, że wpisaliśmy błędny login lub hasło

TEST 2:
Założenia:
Chcemy spróbować się zalogować, a w przypadku wpisania złych credentiali wysłać przypominajkę

Kroki:
1. Wchodzimy na stronę bankier.pl
2. W prawym górnym rogu znajdujemy ikonkę "ludzika" i klikamy na nią
3. Wpisujemy credentiale i wciskamy przycisk "Zaloguj się"
4. Po nieudanym zalogowaniu wciskamy przycisk "Nie pamiętam hasła lub loginu"
5. Wpisujemy login oraz wciskamy przycisk "Przypomij hasło"
6. Otrzymujemy wiadomość - "Podany login lub adres e-mail nie istnieje w bazie Bankier.pl"
