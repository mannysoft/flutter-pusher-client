package com.github.heywhy.flutter_pusher

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import io.flutter.embedding.engine.plugins.FlutterPlugin;

class FlutterPusherPlugin: MethodCallHandler, FlutterPlugin {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "flutter_pusher")
      channel.setMethodCallHandler(FlutterPusherPlugin())
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else {
      result.notImplemented()
    }
  }
  
  override fun onAttachedToEngine(binding: FlutterPluginBinding) {
        
  }

  override fun onDetachedFromEngine(binding: FlutterPluginBinding) {

  }
}
