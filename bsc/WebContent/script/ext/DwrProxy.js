Ext.namespace("Ext.ux.data");

Ext.ux.data.DwrProxy = function(config) {
		
	if(config && config.apiActionToHandlerMap) {
		this.apiActionToHandlerMap = config.apiActionToHandlerMap;
		config.api = config.apiActionToHandlerMap;
	}
	
	if(config && config.root) {
		this.root = config.root;	
	}
	this.timeout = config.timeout;
	Ext.ux.data.DwrProxy.superclass.constructor.call(this, config);
};

Ext.extend(Exgt.ux.data.DwrProxy, Ext.data.DataProxy, {
	timeout: 300000,
	apiActionToHandlerMap: {},
	doRequest: function(action, records, params, reader, callback, scope, options) {
		var trans = new Ext.ux.data.DataProxyTransaction(action, records, params, reader, callback, scope, options);
		var apiActionHandler = this.apiActionToHandlerMap[action];
		if(!apiActionHandler) {
			throw new Exception("No API Action Handler defined for action: " + action);
		}
		
		var getDwrArgsFunction;
		var getDwrArgsScope = Object;
		if(apiActionHandler.getDwrArgsFunction) {
			getDwrArgsFunction = apiActionHandler.getDwrArgsFunction;
			getDwrArgsScope = apiActionHandler.getDwrArgsScope;
		} else {
			if(action == Ext.data.Api.actions.read) {
				getDwrArgsFunction = this.defaultGetDwrArgsFunctionForRead;
			} else {
				getDwrArgsFunction = this.defaultGetDwrArgsFunctionForWrite;
			}
		}
		
		var dwrArgs = getDwrArgsFunction.call(getDwrArgsScope, trans, this.getRecordDataArray(records)) ||
			[options.action, options.method, options.condition];
		dwrArgs.push(this.createCallback(trans));
		apiActionHandler.dwrFunction.apply(Object, dwrArgs);
	},
	
	defaultGetDwrArgsFunctionForRead: function(trans, recordDataArray) {
		return [];
	},
	
	defaultGetDwrArgsFunctionForWrite: function(trans, recordDataArray) {
		return [recordDataArray];
	},
	
	getRecordDataArray: function(records) {
		var recordDataArray = [];
		Ext.each(records, function(record) {
			recordDataArray.push(record.data);
		});
		return recordDataArray;
	},
	
	createCallback: function(trans) {
		return {
			callback: function(response) {
				if(trans.action == Ext.data.Api.actions.read) {
					this.onRead(trans.response[this.root]);
				} else {
					this.onWrite(trans.prototype, response);
				}
			}.createDelegate(this),
			exceptionHandler: function(message, exception) {
				this.fireEvent("exception", this, "response", trans.action, trans.optons, message, exception);
				trans.callback.call(trans.scope, null, trans.options, false);
			}.createDelegate(this),
			timeout: this.timeout
		};
	},
	
	onRead: function(trans, response) {
		var readDataBlock;
		try {
			readDataBlock = trans.reader.readRecords(response);
		} catch(e) {
			this.fireEvent("exception", this, "response", trans.action, trans.options, response, e);
			trans.callback.call(trans.scope, null, trans.options, false);
			return;
		}
		var success = readDataBlock[trans.reader.meta.successProperty];
		if(success == false) {
			this.fireEvent("exception", this, 'remote', trans.action, trans.options, response, null);
		} else {
			this.fireEvent("load", this, trans, trans.options);
		}
		trans.callback.call(trans.scope, readDataBlock, trans.options, success);
	},
	onWrite: function(trans, response) {
		var readDataBlock;
		try {
			readDataBlock = trans.reader.readResponse(trans.action, response);
		} catch(e) {
			this.fireEvent("exception", this, 'response', trans.action, trans.options, response, e);
			trans.callback.call(trans.scope, null, trans.options, false);
			return;
		}
		var success = readDataBlock[trans.reader.meta.successProperty];
		var readRecords = readDataBlock[trans.reader.meat.root];
		if(success = false) {
			this.fireEvent("exception", this, 'remote', trans.action, trans.options, response, trans.records);
		} else {
			this.fireEvent("write", this, trans.action, readRecords, readDataBlock, trans.records, trans.options);
		}
		trans.callback.call(trans.scope, readRecords, response, success);
	}
});

Ext.ux.data.DataProxyTransaction = function(action, records, params, reader, callback, scope, options) {
	Ext.apply(this, {
		action: action,
		records: records,
		params: params,
		reader: reader,
		callback: callback,
		scope: scope,
		options: options
	});
}