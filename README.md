# Arquillian und Wildfly
Arquillian ist ein Testframework, das es ermöglicht, Tests automatisiert durchzuführen.

![arquillian logo](http://design.jboss.org/arquillian/logo/final/arquillian_logo_450px.png)

Dadurch können mühelos Regressionstests erstellt werden. Nutzt man ein CI-Tool wie Jenkins, kann dieses die Ausführung der Tests übernehmen.

Doch wieso Arquillian nutzen, wenn man bereits JUnit verwendet?
Die Verwendung von Arquillian schließt JUnit **nicht** aus. Im Gegenteil. Wenn man so will, erweitert Arquillian JUnit (oder TestNG) um die Möglichkeit, Tests ohne großen Aufwand in bestimmten Umgebungen auszuführen. Oft ist dieses Vorgehen bei JavaEE-Anwendungen notwendig, weil sie voraussetzen, dass bestimmte Aufgaben vom Application-Server übernommen werden.

Um die Verwendung von Arquillian zu demonstrieren, habe ich ein kleines Projekt erstellt.

Folgende Komponenten wurden dabei verwendet:

- Arquillian 1.1.7.Final
- JUnit 4.12
- slf4j (simple) 1.7.12
- Wildfly 8.2.0.Final


Ich habe Java 8 U40 und Maven 3.3.1 verwendet. Wildfly wird mit dem embedded-Adapter für Arquillian gestartet.
Es existieren weitere Adapter für remote- und managed-Verwendung und Glassfish, Weld etc (siehe Doku unter "Quellen"). Diese werden hier nicht verwendet.

In diesem Beispiel werden Enterprise Java Beans und Named-Beans injected, um die Möglichkeit zu demonstrieren. In vielen im Netz vorhandenen Beispielen ist diese Möglichkeit nicht ersichtlich.

Persönlich bin ich sehr von Arquillian überzeugt, weil es sehr einfach zu verwenden ist und recht fehlerfrei funktioniert. Trotz einfacher Handhabung stellt es ein mächtiges Werkzeug dar, um die Qualität von Java-Projekten zu erhöhen.

Mit dem Befehl kann das Projekt geklont werden:
```
git clone https://github.com/heckenmann/arquillian-wildfly-embedded.git
```

**Update:**
Der Vorteil vom managed-Adapter liegt darin, dass man einen bereits gestarteten Wildfly verwenden kann. Das ist sinnvoll, wenn man in der Entwicklungsumgebung sowieso ständig den Server gestartet hat und dieser verwendet werden soll. Dazu muss man die "pom.xml" anpassen indem man den managed-Adapter einbindet und die Property Variable "allowConnectingToRunningServer" auf true setzt. Wie das funktioniert, sieht man im Beispielprojekt wenn man auf den Branch "arquillian-wildfly-managed" wechselt:
<code>
git checkout arquillian-wildfly-managed
</code>

**Quellen:**
- http://arquillian.org/guides/getting_started/
- http://arquillian.org/guides/getting_started_de/
- https://docs.jboss.org/author/display/ARQ/WildFly+8.1.0+-+Embedded
