package com.company;

import com.company.destination.IDestination;
import com.company.source.ISource;

public interface IFormatter {
    void format(ISource source, IDestination destination) throws FormatException;
}
