<?php
$xml = simplexml_load_file("ex10.xml") or die("Error: Cannot load XML file");

echo "<h2>🏏 Cricket Player Stats (PHP)</h2>";
echo "<table border='1' style='border-collapse: collapse;'>";
echo "<tr><th>Name</th><th>Team</th><th>Runs</th></tr>";

foreach ($xml->player as $player) {
    echo "<tr>";
    echo "<td>" . $player->name . "</td>";
    echo "<td>" . $player->team . "</td>";
    echo "<td>" . $player->runs . "</td>";
    echo "</tr>";
}

echo "</table>";
?>
