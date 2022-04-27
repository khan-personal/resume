#!"C:\xampp\perl\bin\perl.exe"

#Print out content header
print "Content-Type: text/html\nPragma: no-cache\n\n";

#print html document
print "<html>";

#print header
print <<EOF;
	<head>
		<title>Bed Data</title>
		<style>		
			.BedTable, .BedTable tr, .BedTable th, .BedTable td {
				border: 2px solid black;
				border-collapse: collapse;
				margin: 10px;
			}

			.Col2, .Col4 {
				background-color: #b3e8ac;
			}
		
			.Col1, .Col3, .Col5 {
				background-color: #e6e5aa;
			}

			.Header {
				background-color: #e28eed;
			}
		</style>
	</head>
EOF

my $filename = 'c:\xampp\htdocs\wk-perl\Question1\demo.txt';

open(FH, '<', $filename);

print("File $filename opened successfully!\n");

my @data;
while (my $line = <FH>) {
	chomp($line);	
	my @linearray = split("\t", $line);
	push(@data, @linearray);
}

my @loop = (1..6);
my $iterator = 0;

my @column1;
my @column2;
my @column3;
my @column4;
my @column5;

for(@loop) {
	push(@column1, $data[$iterator]);
	$iterator++;
	push(@column2, $data[$iterator]);
	$iterator++;
	push(@column3, $data[$iterator]);
	$iterator++;
	push(@column4, $data[$iterator]); # a little dirty here with uninitialized values in final row
	$iterator++;
	push(@column5, $data[$iterator]); # a little dirty here with uninitialized values in final row
	$iterator++;
};

close(FH);

# swap column 2 for column 3
unshift(@column2,@column3);
@column3 = splice(@column2, scalar @column3);

#"database data" for display
my $tableIterator = 1;
my @InputData = (
	{
		Col1 => "$column1[$tableIterator]",
		Col2 => "$column2[$tableIterator]",
		Col3 => "$column3[$tableIterator]",
		Col4 => "$column4[$tableIterator]",
		Col5 => "$column5[$tableIterator]",
		$tableIterator++
	},
	{
		Col1 => "$column1[$tableIterator]",
		Col2 => "$column2[$tableIterator]",
		Col3 => "$column3[$tableIterator]",
		Col4 => "$column4[$tableIterator]",
		Col5 => "$column5[$tableIterator]",
		$tableIterator++
	},
	{
		Col1 => "$column1[$tableIterator]",
		Col2 => "$column2[$tableIterator]",
		Col3 => "$column3[$tableIterator]",
		Col4 => "$column4[$tableIterator]",
		Col5 => "$column5[$tableIterator]",
		$tableIterator++
	},
	{
		Col1 => "$column1[$tableIterator]",
		Col2 => "$column2[$tableIterator]",
		Col3 => "$column3[$tableIterator]",
		Col4 => "$column4[$tableIterator]",
		Col5 => "$column5[$tableIterator]",
		$tableIterator++
	},
	{
		Col1 => "$column1[$tableIterator]",
		Col2 => "$column2[$tableIterator]",
		Col3 => "$column3[$tableIterator]",
		Col4 => "$column4[$tableIterator]",
		Col5 => "$column5[$tableIterator]",
		$tableIterator++
	},
);

#print body
print "<body>";
print "<table class='BedTable'>";

#print table of data
print "<tr class='Header'><th>$column1[0]</th><th>$column2[0]</th><th>$column3[0]</th><th>$column4[0]</th><th>$column5[0]</th></tr></td>";

#Loop through array and print out Bed data
foreach $Bed (@InputData) {
	my %Bed = %$Bed;
	#print Bed record
	print "<tr>";
	print "<td class='Col1'>$Bed{Col1}</td>";
	print "<td class='Col2'>$Bed{Col2}</td>";
	print "<td class='Col3'>$Bed{Col3}</td>";
	print "<td class='Col4'>$Bed{Col4}</td>";
	print "<td class='Col5'>$Bed{Col5}</td>";
	print "</tr>";
}

print "</table>";
print <<EOF;

EOF
print "</body></html>";
exit;