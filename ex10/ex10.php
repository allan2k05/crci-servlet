<?php
$xml = simplexml_load_file("ex10.xml") or die("Error: Cannot load XML file");

echo "
<!DOCTYPE html>
<html>
<head>
    <title>Cricket Player Stats (PHP)</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background-color: #f5f7fa;
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        table {
            border-collapse: collapse;
            width: 60%;
            background: #fff;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            text-align: left;
            padding: 12px 15px;
        }

        th {
            background-color: #007bff;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        tr:nth-child(even) {
            background-color: #f2f6fc;
        }

        tr:hover {
            background-color: #e9f1ff;
            transition: background 0.2s ease;
        }
    </style>
</head>
<body>
";

echo "<h2>🏏 Cricket Player Stats (PHP)</h2>";
echo "<table border='1'>";
echo "<tr><th>Name</th><th>Team</th><th>Runs</th></tr>";

foreach ($xml->player as $player) {
    echo "<tr>";
    echo "<td>" . htmlspecialchars($player->name) . "</td>";
    echo "<td>" . htmlspecialchars($player->team) . "</td>";
    echo "<td>" . htmlspecialchars($player->runs) . "</td>";
    echo "</tr>";
}

echo "</table>
</body>
</html>";
?>
