package com.glomaksi.core.service;

import com.glomaksi.core.bean.Operation;

import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final List<Operation> operations;

    public OperationServiceImpl(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public List<Operation> getOperation() {
        return operations;
    }
}
