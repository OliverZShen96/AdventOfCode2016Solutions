#!/usr/bin/perl 
$count = 0;
while ($line = <>) {
	$SSL = 0;
	chomp $line;
	my @ABAS;
	my @inBrackets = ($line =~ /\[\w*\]/g);
	$line =~ s/\[\w*\]//g;
	foreach $bracketExpression (@inBrackets){
		push @ABAS, $1 if ($bracketExpression =~ /((\w)(?!\2)(\w)\2)/g);
	}

	foreach $ABA (@ABAS) {
		my @chars = split("", $ABA);
		$BAB = @chars[1].@chars[0].@chars[1];
		if ($line =~ /$BAB/) {
			$SSL = 1; 
		}
	}
	$count++ if ($SSL);

}
print "$count\n";