import jenkins.model.*
import hudson.model.*
import hudson.tools.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.model.JDK")

def versions = [
  "java-1.8.0-openjdk-system": "/usr/lib/jvm/java-1.8.0-openjdk",
  "java-11-openjdk-system": "/usr/lib/jvm/java-11-openjdk",
  "java-1.8.0-oracle": "/var/lib/jenkins/.sdkman/candidates/java/8.0.201-oracle",
  "java-11-openjdk": "/var/lib/jenkins/.sdkman/candidates/java/11.0.2-open",
  "java-12-openjdk": "/var/lib/jenkins/.sdkman/candidates/java/12.0.0-open",
  "java-13-ea": "/var/lib/jenkins/.sdkman/candidates/java/13.ea.15-open",
  "graalvm-1.0.0-rc-14": "/var/lib/jenkins/.sdkman/candidates/java/1.0.0-rc-14-grl",
  "graalvm-1.0.0-rc-15": "/var/lib/jenkins/.sdkman/candidates/java/1.0.0-rc-15-grl",
  "graalvm": "/var/lib/jenkins/.sdkman/candidates/java/1.0.0-rc-15-grl",
]
def installations = [];

for (v in versions) {
  def installation = new JDK(v.key, v.value)
  installations.push(installation)
}

desc.setInstallations(installations.toArray(new JDK[0]))
desc.save()