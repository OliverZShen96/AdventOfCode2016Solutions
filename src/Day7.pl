#!/usr/bin/perl 
$count = 0;
while ($line = <>) {
	chomp $line;
	my @ABAS;

	# The various bracket expressions
	my @inBrackets = ($line =~ /\[\w*\]/g);

	# The rest of the line
	$line =~ s/\[\w*\]//g;

	# Find all ABAS present within square brackets and store them inside an array
	foreach $bracketExpression (@inBrackets){
		push @ABAS, ($bracketExpression =~ /(?=((.)(?!\2).\2))/g);
	}

	# Couldn't figure out how to only store actual matches
	# Backref matches are also stored, so they are deleted afterwards
	foreach my $index (0 .. $#ABAS) {
        delete $ABAS[$index] if (length($ABAS[$index]) != 3);
    }

    # Search for occurences of corresponding BAB for each ABA
	foreach $ABA (@ABAS) {
		my @chars = split("", $ABA);
		$BAB = @chars[1].@chars[0].@chars[1];
		if ($line =~ /$BAB/) {
			$count++;
			last;
		}
	}

}
print "$count\n";